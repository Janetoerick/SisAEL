package com.ufrn.cb.SisAEL.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Admin;
import com.ufrn.cb.SisAEL.entity.Cliente;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private FachadaDados fachada;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Optional<Cliente> dadosCliente;

		dadosCliente = 
				fachada.obterCliente(username);
		if(dadosCliente.isPresent()) {
			GrantedAuthority g =new SimpleGrantedAuthority("cliente");

			return new UserDetails() {

				private static final long serialVersionUID = 1L;

				@Override
				public boolean isEnabled() {
					return true;
				}

				@Override
				public boolean isCredentialsNonExpired() {
					return true;
				}

				@Override
				public boolean isAccountNonLocked() {
					return true;
				}

				@Override
				public boolean isAccountNonExpired() {
					return true;
				}

				@Override
				public String getUsername() {

					return dadosCliente.get().getNomeUsuario();
				}

				@Override
				public String getPassword() {

					return dadosCliente.get().getSenha();
				}

				@Override
				public Collection<? extends 
						GrantedAuthority> getAuthorities() {

					ArrayList<GrantedAuthority> collection = 
							new ArrayList<GrantedAuthority>();
					collection.add(g);
					return collection;
				}
			};
		}
		else{
			Optional<Admin> dadosTecnico = fachada.obterAdmin(username);
			if(dadosTecnico.isPresent()) {
				GrantedAuthority g =new SimpleGrantedAuthority("admin");

				return new UserDetails() {

					private static final long serialVersionUID = 2L;

					@Override
					public boolean isEnabled() {
						return true;
					}

					@Override
					public boolean isCredentialsNonExpired() {
						return true;
					}

					@Override
					public boolean isAccountNonLocked() {
						return true;
					}

					@Override
					public boolean isAccountNonExpired() {
						return true;
					}

					@Override
					public String getUsername() {

						return dadosTecnico.get().getNomeUsuario();
					}

					@Override
					public String getPassword() {

						return dadosTecnico.get().getSenha();
					}

					@Override
					public Collection<? extends GrantedAuthority> getAuthorities() {

						ArrayList<GrantedAuthority> collection = 
								new ArrayList<GrantedAuthority>();
						collection.add(g);
						return collection;
					}
				};

			}else {

				throw new UsernameNotFoundException("Nome de Usuário não encontrado");
			}

		}


	}

}
