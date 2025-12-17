package model;

import java.nio.file.DirectoryNotEmptyException;

public class Persona {
		    
	
		    // 1. ATRIBUTOS (Las variables que definen a la persona)
		    // Son 'private' por encapsulamiento (regla de oro de POO)
		    private String nombre;
		    private String profesion;
		    private String descripcion;
		    private String color;
		    private String contacto;
		    
		    // 2. CONSTRUCTOR (El método que se ejecuta al hacer 'new Persona(...)')
		    public Persona(String nombre, String profesion, String descripcion, String color, String contacto) {
		        this.nombre = nombre;
		        this.profesion = profesion;
		        this.descripcion = descripcion;
		        this.color = color;
		        this.contacto = contacto;
		    }
		    
		    // 3. MÉTODOS (Lo que la persona "sabe hacer")
		    
		    // Este método devuelve un String gigante con tu HTML y las variables incrustadas
		    public String generarHTML() {
		    	
		    	String htmlBoton ="";
		    	
		    	if (!this.contacto.isBlank()) {
		    		htmlBoton = "<a href='" + this.contacto + "' class='btn btn-primary' target='_blank'>Contactar en LinkedIn</a>";
		    	}
		    	
		        return """
		            <!DOCTYPE html>
		            <html lang="es">
		            <head>
		                <meta charset="UTF-8">
		                <meta name="viewport" content="width=device-width, initial-scale=1.0">
		                <title>Perfil de %s</title> 
		                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
		            </head>
		            <body class="bg-light">
		            
		            <header id="inicio" class="bg-dark text-white p-5 text-center">
		                <h1 class="display-4">Tarjeta de presentación</h1>
		            </header>
		            
		            <div class="container mt-5">
		              <div class="row justify-content-center">
		                <div class="col-12 col-md-6 col-lg-4">
		                  
		                  <div class="card shadow" style="background-color: %s;">
		                    <img src="https://placehold.co/600x400" class="card-img-top" alt="Foto de perfil">
		                    
		                    <div class="card-body text-center">
		                      <h5 class="card-title">%s</h5> 
		                      <h6 class="card-subtitle mb-2 text-muted">%s</h6>
		                      <p class="card-text">%s</p>
		                      
		                      %s
		                      
		                    </div>
		                  </div>
		                  
		                </div>
		              </div>
		            </div>
		            
		            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>    
		            </body>
		            </html>
		            """.formatted(this.nombre, this.color, this.nombre, this.profesion, this.descripcion, this.contacto, htmlBoton);
		    }
}

