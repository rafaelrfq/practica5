<#include "base.ftlh">

<#macro page_body>
    <h1 class="text-center">Message List</h1><br>
    <div class="container">

        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Device ID</th>
                <th scope="col">Date Generated</th>
                <th scope="col">Temperature</th>
                <th scope="col">Humidity</th>
            </tr>
            </thead>
            <tbody>
            <#if mensajes??>
                <#list mensajes as msj>
                    <tr>
                        <th scope="row">${msj.id}</th>
                        <td>${msj.idDispositivo}</td>
                        <td>${msj.fechaGeneracion}</td>
                        <td>${msj.temperatura}</td>
                        <td>${msj.humedad}</td>
                    </tr>
                </#list>
            <#else>
                <tr>
                    <td colspan="5">No data was found</td>
                </tr>
            </#if>
            </tbody>
        </table>
    </div>
</#macro>

<@display_page />