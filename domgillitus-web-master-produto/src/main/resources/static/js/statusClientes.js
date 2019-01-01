$(document).ready(function () {

    $("#clientes_menu").attr('class', 'active');
    $("#tb_clientes").DataTable({
        "language": {
            "lengthMenu": "Mostrando _MENU_ registros por página",
            "zeroRecords": "Nenhum registro encontrado",
            "info": "Página _PAGE_ de _PAGES_",
            "infoEmpty": "Nenhum registro disponível",
            "sLoadingRecords": "Carregando clientes...",
            "sSearch": "Pesquisar",
            "oPaginate": {
                "sNext": "Próximo",
                "sPrevious": "Anterior"
            }
        }
    });

});