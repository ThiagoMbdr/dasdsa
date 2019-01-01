$(document).ready(function () {

    $("#clientes_menu").attr('class', 'active');

    if ($("#tipo_telefone").val() == 1){
        if ($("#id").val() > 0) {
            $("#telefone").attr('placeholder', 'Informe o telefone fixo').mask('(99)9999-9999', {reverse: false});
        }else {
            $("#telefone").attr('placeholder', 'Informe o telefone fixo').val('').mask('(99)9999-9999', {reverse: false});
        }
    }else {
        if ($("#id").val() > 0){
            $("#telefone").attr('placeholder', 'Informe o celular').mask('(99)99999-9999', {reverse: false});
        } else {
            $("#telefone").attr('placeholder', 'Informe o celular').val('').mask('(99)99999-9999', {reverse: false});
        }
    }


    $("#tipo_telefone").change(function () {
        if ($("#tipo_telefone").val() == 1){
            $("#telefone").attr('placeholder', 'Informe o telefone fixo').val('').mask('(99)9999-9999', {reverse: false});
        }else {
            $("#telefone").attr('placeholder', 'Informe o celular').val('').mask('(99)99999-9999', {reverse: false});
        }
    });

    $("#form_cliente").submit(function (e) {
        e.preventDefault();

        if ($("#id").val() > 0){

            //CÓDIGO PARA ATUALIZAR
            $.ajax({
                url: ENDERECOSERVIDOR + '/cliente_atualizar',
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