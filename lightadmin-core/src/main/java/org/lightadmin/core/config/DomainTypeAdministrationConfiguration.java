package org.lightadmin.core.config;

import org.lightadmin.core.repository.DynamicJpaRepository;
import org.lightadmin.core.view.ScreenContext;
import org.lightadmin.core.view.support.Fragment;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public class DomainTypeAdministrationConfiguration {

	private JpaEntityInformation<?, ? extends Serializable> entityInformation;

	private final Class<?> domainType;

	private final DynamicJpaRepository<?, ?> repository;

	private Fragment listViewFragment;

	private ScreenContext screenContext;

	public DomainTypeAdministrationConfiguration( final Class<?> domainType, final DynamicJpaRepository<?, ?> repository ) {
		this.domainType = domainType;
		this.repository = repository;
	}

	@PersistenceContext
	public void setEntityManager( EntityManager entityManager ) {
		entityInformation = JpaEntityInformationSupport.getMetadata( domainType, entityManager );
	}

	public JpaEntityInformation getEntityInformation() {
		return entityInformation;
	}

	public Class<?> getDomainType() {
		return domainType;
	}

	public DynamicJpaRepository<?, ?> getRepository() {
		return repository;
	}

	public String getDomainTypeName() {
		return StringUtils.uncapitalize( entityInformation.getEntityName() );
	}

	public Fragment getListViewFragment() {
		return listViewFragment;
	}

	public void setListViewFragment( final Fragment listViewFragment ) {
		this.listViewFragment = listViewFragment;
	}

	public void setScreenContext( final ScreenContext screenContext ) {
		this.screenContext = screenContext;
	}

	public ScreenContext getScreenContext() {
		return this.screenContext;
	}
}