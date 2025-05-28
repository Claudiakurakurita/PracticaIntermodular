document.addEventListener("DOMContentLoaded", function() {
    const datos = [
        { continente: "Europa", pais: "España", monumento: "Valle de los Caídos" },
        { continente: "Europa", pais: "Francia", monumento: "Mbappe" },
        { continente: "Asia", pais: "Japón", monumento: "Yonaguni" },
        { continente: "Asia", pais: "China", monumento: "La Glan Mulaya (-|_|-)" },
        { continente: "America", pais: "Estados Unidos", monumento: "World Trade Center" },
        { continente: "America", pais: "Brasil", monumento: "Vinicius Jr." },
        { continente: "Oceania", pais: "Chile", monumento: "Rapa Nui" },
        { continente: "Oceania", pais: "Tonga", monumento: "Ha'amonga 'a Maui" },
        { continente: "Africa", pais: "Zimbabwe", monumento: "Gran Zimbabwe" },
        { continente: "Africa", pais: "Uganda", monumento: "Tumbas de los reyes de Buganda" }
    ];
    const tabla = document.getElementById("tabla-datos");
    const selectContinente = document.getElementById("continente");
    function mostrarDatos(filtro) {
        tabla.innerHTML = "";
        datos.forEach(item => {
        if (!filtro || item.continente === filtro) {
        const fila = `<tr>
        <td>${item.continente}</td>
        <td>${item.pais}</td>
        <td>${item.monumento}</td>
        </tr>`;
        tabla.innerHTML += fila;
    }
    });
    }
    selectContinente.addEventListener("change", function() {
    mostrarDatos(this.value);
    });
    mostrarDatos();
});
