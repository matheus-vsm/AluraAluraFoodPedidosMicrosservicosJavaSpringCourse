package br.com.alurafood.pedidos.amqp;

import br.com.alurafood.pedidos.dto.PagamentoDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PagamentoListener {

    @RabbitListener(queues = "pagamentos.detalhes-pedido")
    public void receberMensagem(PagamentoDto pagamento) {
        String mensagem = """
                Dados do Pagamento %s;
                Número do Pedido: %s;
                Nome do Cliente: %s;
                Valor R$%s;
                Status: %s
                """.formatted(pagamento.getId(), pagamento.getPedidoId(), pagamento.getNome(),
                pagamento.getValor(), pagamento.getStatus());
        System.out.println("Mensagem Recebida: \n" + mensagem);
    }

}
