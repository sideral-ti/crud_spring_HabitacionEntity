document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("habitacion-form");

    form.addEventListener("submit", (e) => {
        const numero = document.getElementById("numero").value.trim();
        const nombre = document.getElementById("nombre").value.trim();

        if (!numero || !nombre) {
            e.preventDefault();
            alert("Los campos Número y Nombre son obligatorios.");
        }
    });
});

$(document).ready(function() {
    $('#habitacionForm').on('submit', function(e) {
        e.preventDefault();

        const habitacion = {
            numero: $('#numero').val(),
            nombre: $('#nombre').val(),
            tipo: $('#tipo').val(),
            precio: parseFloat($('#precio').val()),
            capacidad: parseInt($('#capacidad').val()),
            estado: $('#estado').val(),
            piso: parseInt($('#piso').val()),
            descripcion: $('#descripcion').val(),
            imagenPrincipal: $('#imagenPrincipal').val(),
            terraza: $('#terraza').is(':checked'),
            vistaAlMar: $('#vistaAlMar').is(':checked')
        };

        $.ajax({
            url: '/rest/habitaciones',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(habitacion),
            success: function(response) {
                alert('Habitación guardada exitosamente');
                $('#habitacionForm')[0].reset();
            },
            error: function(xhr) {
                alert('Error al guardar: ' + xhr.responseJSON.message);
            }
        });
    });
});