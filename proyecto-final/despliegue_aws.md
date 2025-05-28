# Despliegue del sitio web en AWS (EC2)

## Requisitos
- Crear una máquina virtual en AWS EC2 (Ubuntu o Windows)
- Instalar un servidor web (Apache o Nginx)
- Copiar los archivos del sitio al servidor (vía SCP/SFTP)
- Configurar el servidor web para acceso público
- Comprobar el acceso desde navegador mediante URL pública

---

## 1. Creación de la instancia en AWS

Se ha creado una instancia EC2 con las siguientes características:

- **Sistema operativo**: Ubuntu Server 22.04 LTS (64-bit)
- **Tipo de instancia**: t2.micro (gratuita)
- **Par de claves**: `nombre-clave.pem` para acceso SSH
- **Grupo de seguridad**: Puertos 22 (SSH) y 80 (HTTP) abiertos

**Captura:**  
![Creación de la instancia EC2](./capturas/1_creacion_instancia.png)

---

## 2. Instalación del servidor Apache

Una vez conectados por SSH a la instancia con:

```bash
ssh -i nombre-clave.pem ubuntu@<IP-PUBLICA>
