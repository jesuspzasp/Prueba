package modelo;

public enum CategoriaEnum {
	
	ACTIVO, INACTIVO;
	
	 public CategoriaEnum parse(String text){
	        if(ACTIVO.name().equalsIgnoreCase(text)){
	            return ACTIVO;
	        } else {
	            return INACTIVO;
	        }
	    }
	
	
}
