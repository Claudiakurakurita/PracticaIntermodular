☁ Requisitos de Sistemas Informáticos.
Cada grupo deberá desplegar su sitio web (realizado en HTML, CSS y JS) en una instancia
remota en la nube, utilizando una máquina virtual en AWS (EC2 con Linux o Windows
Server) o un proveedor equivalente.
Requisitos técnicos:
● Crear una máquina virtual en AWS (EC2) con un sistema operativo Linux (Ubuntu o
similar) o Windows.
● Instalar un servidor web (por ejemplo, Apache o Nginx).
● Copiar los archivos del sitio web al servidor (por ejemplo, vía SCP o SFTP).
● Configurar el servidor web para que los archivos sean accesibles públicamente.
● Comprobar que el sitio es accesible desde un navegador mediante una URL pública.
Documentación:
● Capturas de los siguientes pasos:
○ Creación de la instancia en AWS.
○ Instalación del servidor web.
○ Estructura de archivos desplegada.
○ Página cargando correctamente desde el navegador.
● Incluir todas las capturas y explicaciones en un fichero despliegue_aws.md dentro
del repositorio.


🎯 Objetivo
Configurar un servidor web Linux utilizando una instancia EC2 de Amazon Web Services (AWS) para alojar y visualizar la página web desarrollada en el proyecto intermodular.

🧩 Tareas a realizar
Creación de una instancia EC2:

Lanza una máquina virtual Ubuntu desde la consola de AWS.

Configura correctamente las reglas del grupo de seguridad, permitiendo tráfico de entrada por los puertos:

22 (SSH) – para conexiones seguras a la terminal.

80 (HTTP) – para servir páginas web.

443 (HTTPS) – para conexiones web seguras.

Descarga tu clave privada .ppk y guárdala de forma segura.

Si se indica, renómbrala como vockey.ppk.

Conexión a la instancia:

Conéctate a la instancia EC2 mediante SSH, utilizando:

PuTTY desde Windows.

WinSCP o FileZilla (modo SFTP).

O desde el navegador usando el cliente SSH de AWS.

Instalación del entorno web con tasksel:

a. Instalar tasksel:
Ejecuta en la terminal de la instancia:

sudo apt update
sudo apt install tasksel

b. Ejecutar tasksel:
Una vez instalado, lanza la herramienta:

sudo tasksel

c. Instalar servidor web:
En el menú que aparece, selecciona “web server” (Linux, Apache, MySQL, PHP).

Usa la barra espaciadora para seleccionarlo y pulsa Enter para instalar.

Se instalará Apache como servidor web, junto con PHP y MySQL.

image.png

Transferencia de archivos web:

Usa SFTP (mediante FileZilla o WinSCP) para subir la carpeta de tu sitio web al directorio /home/ubuntu.

Como no tienes permisos directos sobre /var/www/html, deberás mover los archivos con privilegios:

sudo cp -r /home/ubuntu/tu_carpeta /var/www/html
Visualización del sitio web:

Abre un navegador y accede a tu servidor mediante su IP pública o DNS público.

Debería mostrarse la página web que has subido.

📌 Entrega y evaluación
La actividad se evaluará en grupo como parte del desarrollo del proyecto intermodular.

Cada grupo deberá demostrar:

El acceso funcional a su servidor web.

La correcta visualización de su página.

Una explicación del proceso realizado.

Se valorará especialmente:

La correcta configuración de seguridad.

El uso adecuado de herramientas (SSH, SFTP, tasksel).

La comprensión del manejo de permisos y rutas.
