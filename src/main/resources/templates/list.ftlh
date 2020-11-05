<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listado</title>
</head>
<body>
    <div class="container">
        <h1>Listado de mensajes</h1>
        <ol>
            <#list mensajes as msj>
                <li>
                    Dispositivo: ${msj.idDispositivo}
                    <br></br>ID: ${msj.id}
                    <br>Fecha: ${msj.fechaGeneracion}
                    <br>Temperatura: ${msj.temperatura}
                    <br>Humedad: ${msj.humedad}
                </li>
            </#list>
        </ol>
    </div>
</body>
</html>