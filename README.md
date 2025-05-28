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

 

¡¡¡IMPORTANTE!!! ¡No olvides entregar individualmente las capturas de pantalla que ha indicado el profesor en clase, donde se demuestre el correcto funcionamiento de la web desplegada en Amazon Web Services (AWS)!
