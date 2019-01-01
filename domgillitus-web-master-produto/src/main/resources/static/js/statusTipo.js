$(document).ready(function () {

    $("#tipo_menu").attr('class', 'active');
    $("#tb_tipoproduto").DataTable({
        "language": {
            "lengthMenu": "Mostrando _MENU_ registros por página",
            "zeroRecords": "Nenhum registro encontrado",
            "info": "Página _PAGE_ de _PAGES_",
            "infoEmpty": "Nenhum registro disponível",
            "sLoadingRecords": "Carregando tipo de produtos...",
            "sSearch": "Pesquisar",
            "oPaginate": {
                "sNext": "Próximo",
                "sPrevious": "Anterior"
            }
        }
    });

