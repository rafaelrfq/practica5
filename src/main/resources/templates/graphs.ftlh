<#include "base.ftlh">

<#macro page_body>

    <br>
    <h1 class="text-center">Graphs</h1>
    <br>

    <h3>Dispositivo 1</h3><br>

    <div class="row">
        <div class="col-md-6">
            <div id="chart_div1"></div>
        </div>
        <div class="col-md-6">
            <div id="chart_div2"></div>
        </div>
    </div>

    <h3>Dispositivo 2</h3><br>

    <div class="row">
        <div class="col-md-6">
            <div id="chart_div3"></div>
        </div>
        <div class="col-md-6">
            <div id="chart_div4"></div>
        </div>
    </div>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {packages: ['corechart', 'line']});
        google.charts.setOnLoadCallback(drawBackgroundColor);

        function drawBackgroundColor() {
            var data1 = new google.visualization.DataTable();
            data1.addColumn('number', 'X');
            data1.addColumn('number', 'Temperature');

            data1.addRows([
                [0, 0],   [10, ${tempDisp1[0]}],  [20, ${tempDisp1[1]}],  [30, ${tempDisp1[2]}],  [40, ${tempDisp1[3]}], [50, ${tempDisp1[4]}]
            ]);

            var options1 = {
                hAxis: {
                    title: 'Time'
                },
                vAxis: {
                    title: 'Temperature'
                },
                backgroundColor: '#f1f8e9'
            };

            var chart1 = new google.visualization.LineChart(document.getElementById('chart_div1'));

            // ===================================================================================

            var data2 = new google.visualization.DataTable();
            data2.addColumn('number', 'X');
            data2.addColumn('number', 'Humidity');

            data2.addRows([
                [0, 0],   [10, ${humDisp1[0]}],  [20, ${humDisp1[1]}],  [30, ${humDisp1[2]}],  [40, ${humDisp1[3]}], [50, ${humDisp1[4]}]
            ]);

            var options2 = {
                hAxis: {
                    title: 'Time'
                },
                vAxis: {
                    title: 'Humidity'
                },
                backgroundColor: '#f1f8e9'
            };

            var chart2 = new google.visualization.LineChart(document.getElementById('chart_div2'));

            // ===================================================================================

            var data3 = new google.visualization.DataTable();
            data3.addColumn('number', 'X');
            data3.addColumn('number', 'Temperature');

            data3.addRows([
                [0, 0],   [10, ${tempDisp2[0]}],  [20, ${tempDisp2[1]}],  [30, ${tempDisp2[2]}],  [40, ${tempDisp2[3]}], [50, ${tempDisp2[4]}]
            ]);

            var options3 = {
                hAxis: {
                    title: 'Time'
                },
                vAxis: {
                    title: 'Temperature'
                },
                backgroundColor: '#f1f8e9'
            };

            var chart3 = new google.visualization.LineChart(document.getElementById('chart_div3'));

            // ===================================================================================

            var data4 = new google.visualization.DataTable();
            data4.addColumn('number', 'X');
            data4.addColumn('number', 'Humidity');

            data4.addRows([
                [0, 0],   [10, ${humDisp2[0]}],  [20, ${humDisp2[1]}],  [30, ${humDisp2[2]}],  [40, ${humDisp2[3]}], [50, ${humDisp2[4]}]
            ]);

            var options4 = {
                hAxis: {
                    title: 'Time'
                },
                vAxis: {
                    title: 'Humidity'
                },
                backgroundColor: '#f1f8e9'
            };

            var chart4 = new google.visualization.LineChart(document.getElementById('chart_div4'));

            // ===================================================================================

            chart1.draw(data1, options1);
            chart2.draw(data2, options2);
            chart3.draw(data3, options3);
            chart4.draw(data4, options4);
        }
    </script>

</#macro>

<@display_page/>