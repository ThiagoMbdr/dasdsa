$(document).ready(function () {

    $("#produtos_menu").attr('class', 'active');




    $("#form_produtos").submit(function (e) {
        e.preventDefault();

        if ($("#id").val() > 0){

            //CÓDIGO PARA ATUALIZAR
            $.ajax({
                url: ENDERECOSERVIDOR + '/produtos_atualizar',
                method: 'POST',
                data: $("#form_produtos").serialize(),
                beforeSend: function () {
                    console.log($("#form_produtos").serialize());
                    let valido = true;
                    return valido;
                },
                success: function () {
                    location.href = '/produtos_listar';
                }
            });

        }else {
            //CÓDIGO PARA CADASTRO
            $.ajax({
                url: ENDERECOSERVIDOR + '/produtos_cadastro',
                method: 'POST',
                data: $("#form_produtos").serialize(),
                beforeSend: function () {
                    console.log($("#form_produtos").serialize());
                    let valido = true;
                    return valido;
                },
                success: function () {
                    location.href = '/produtos_listar';
                }
            });

        }

    });

});