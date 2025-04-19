# Proyecto Concurrencia

## API Utilizada
Elegi utilizara REST Countries API, porque provee rapidamente datos de paises en formato JSON con tan solo acceder a una URL.

## Implementaciones Principales 
Se impllementaron 2 proyectos, un proyecto llamado CountriesApiServicesCF que contiene el acceso a la API y funciona como una libreria, este contiene metodos predefinidos para obtener y tratar datos de la API. Y otro proyecto ConcurrenciaCF que contiene la implementacion de los metodos de la libreria para obtener datos de la API y mostrarlos en pantalla.
Mediante la modularizacion de la libreria solo se exportan los metodos de tratamiento de datos y los tipos de datos necesarios para que el proyecto principal pueda utilizar los datos de la API.

## Metodos Implementados
Se implementaron 4 metodos con 2 variantes cada uno, una implementacion con concurrencia y otra sin concurrencia. El objetivo es poder modir el tiempo de ejecucion de los metodos con y sin concurrencia.
Los metodos son: 
- obtenerPesoTotalBanderasConcurrente
- obtenerPesoTotalBanderasNoConcurrente
- obtenerPaisConMayorPoblacionConcurrente
- obtenerPaisConMayorPoblacionNoConcurrente
- obtenerTop10PaisesMasGrandesConcurrente
- obtenerTop10PaisesMasGrandesNoConcurrente
- obtenerIdiomasMasComunesConcurrente
- obtenerIdiomasMasComunesNoConcurrente

De estos metodos destacamos un aprendizaje, el metodo obtenerPesoTotalBanderasConcurrente es el que destaca con una mayor reduccion de tiempo de ejecuccion aprovechandose de la concurrencia, ya que tiene que realizar una peticion a una URL por cada pais, ya que la API nos devuelve la URL de la bandera.
Los demas metodos al no ser operaciones tan complejas no se aprecia una mejora significativa en el tiempo de ejecuccion, incluso puede llegar a ser mas lento debido a una sobreingenieria en operaciones sobre los datos.

## 🛠️ Tecnologías Utilizadas
- Java 23


## 🚀 Instalación y Configuración

### Prerrequisitos
- Java JDK 23


### Pasos de Instalación
1. Clonar el repositorio
```
git clone https://github.com/Kdna-dev/codigofacilito-concurrencia.git
```




## 🤝 Contribuir
1. Fork el proyecto
2. Crea tu rama de características (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add: alguna característica asombrosa'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request


## ✍️ Autor
Santiago Cabrera - [@Kdna-dev](https://github.com/Kdna-dev)


## 🙏 Agradecimientos
- A Codigo Facilito por brindarme la oportunidad de desarrollar este desafiante proyecto
- A la comunidad de Java por su excelente documentación