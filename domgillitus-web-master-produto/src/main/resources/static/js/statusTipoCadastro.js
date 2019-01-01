$(document).ready(function () {

    $("#tipos_menu").attr('class', 'active');

;

    $("#form_tipo").submit(function (e) {
        e.preventDefault();

        if ($("#id").val() > 0){

            //CÓDIGO PARA ATUALIZAR
            $.ajax({
                url: ENDERECOSERVIDOR + '/tipo_atualizar',
                method: 'POST',
                data: $("#form_tipo").serialize(),
                beforeSend: function () {
                    console.log($("#form_tipo").serialize());
                    let valido = true;
                    if ($("#ponto_referencia").length > 255){
                        valido = false;
                        alert('O campo ponto de referência so pode ter 255 caracteres');
                    }
                    return valido;
                },
                success: function () {
                    location.href = '/clientes_listar';
                }
            });

        }else {
            //CÓDIGO PARA CADASTRO
            $.ajax({
                url: ENDERECOSERVIDOR + '/cliente_cadastro',
                method: 'POST',
                data: $("#form_cliente").serialize(),
                beforeSend: function () {
                    console.log($("#form_cliente").serialize());
                    let valido = true;
                    if ($("#ponto_referencia").length > 255){
                        valido = false;
                        alert('O campo ponto de referência so pode ter 255 caracteres');
                    }
                    return valido;
                },
                success: function () {
                    location.href = '/clientes_listar';
                }
            });

        }

    });

});