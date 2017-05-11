<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">termékek</h3>
    </div>
    <div class="panel-body">
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#basic" aria-controls="basic" role="tab" data-toggle="tab">Raktárkészlet</a></li>
            <li role="presentation"><a href="#stats" aria-controls="round" role="tab" data-toggle="tab">Statisztikák</a></li>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="basic"><jsp:include page="product_list.jsp" /></div>
            <div role="tabpanel" class="tab-pane" id="stats"><jsp:include page="stats.jsp" /></div>
        </div>
    </div>
</div>


<script>
    window.onload = function () {
    }
</script>

</body>
</html>
