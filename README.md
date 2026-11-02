# Cafeteria — Integração de Strategy, Factory Method, Template Method e Singleton

Projeto didático que integra quatro padrões do GoF no fluxo de um pedido de cafeteria.

| Padrão | Onde | Papel no sistema |
|---|---|---|
| Singleton | `config.ConfiguracaoLoja` | Guarda o nome da loja e a taxa de serviço, compartilhados por todo o sistema |
| Template Method | `bebidas.Bebida` | `preparar()` é final e fixa a ordem dos passos; cada bebida preenche só o que muda |
| Factory Method | `bebidas.BebidaFactory` | Cria a bebida pelo nome, via reflection (mesmo estilo do exemplo do professor) |
| Strategy | `desconto.IEstrategiaDesconto` | Regra de desconto intercambiável: sem desconto, estudante ou fidelidade |

## Estrutura de pacotes

```
org.example.cafeteria
├── config     -> Singleton
├── desconto   -> Strategy
├── bebidas    -> Template Method + Factory Method
└── pedido     -> Integração dos quatro padrões
```

## Como os padrões se conectam

`Pedido` é o ponto único de integração:

1. cria a bebida pelo nome com o **Factory Method** (`BebidaFactory`);
2. a bebida criada se prepara pelo **Template Method** (`Bebida.preparar()`);
3. o preço passa pela **Strategy** de desconto escolhida;
4. o **Singleton** `ConfiguracaoLoja` fornece a taxa de serviço e o nome da loja.

Total = (preço da bebida com desconto) x (1 + taxa de serviço / 100).