package br.com.appnovo.service;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.appnovo.service.interfaces.ICustomService;

@Service
public abstract class CustomService<R,T,I> implements ICustomService<T, I> {

	private R repository;
	
	public R getRepository() {
		return repository;
	}

	public void setRepository(R repository) {
		this.repository = repository;
	}

	
	
	@SuppressWarnings({ "unchecked", "unused" })
	private String getGenericName(){      	
        return ((Class<R>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
    }
	
	@SuppressWarnings({"unchecked"} )
	private String getGenericNamePK(){      	
        return ((Class<I>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[2]).getTypeName();
    }		
	
	
	public abstract void LoadData();
	
	@Override
	public List<T> Listar() {
		LoadData();
		/*
		Method method;
		try {
			method = repository.getClass().getMethod("findAll");
  		    Object o = method.invoke(repository);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		*/
			
		List<T> lista = new ArrayList<T>();//((List<Object>)o).stream().map(x->new T(x)).collect(Collectors.toList());
			
		return lista;
	}

	@Override
	public T Item(I id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T Inserir(T item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T Atualizar(T item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Deletar(I id) {
		// TODO Auto-generated method stub
		return false;
	}

}
