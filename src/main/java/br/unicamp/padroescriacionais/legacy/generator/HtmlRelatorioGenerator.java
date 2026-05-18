package br.unicamp.padroescriacionais.legacy.generator;

import br.unicamp.padroescriacionais.legacy.domain.Relatorio;

public class HtmlRelatorioGenerator implements RelatorioGenerator {

    @Override
    public String gerar(Relatorio relatorio) {
        StringBuilder sb = new StringBuilder();

        sb.append("<html>\n");
        sb.append("<body>\n");

        sb.append("<h1>")
                .append(relatorio.getTitulo())
                .append("</h1>\n");

        sb.append("<p><strong>Tipo:</strong> ")
                .append(relatorio.getTipo())
                .append("</p>\n");

        sb.append("<p><strong>Gerado em:</strong> ")
                .append(relatorio.getDataGeracao())
                .append("</p>\n");

        sb.append("<pre>")
                .append(relatorio.getConteudo())
                .append("</pre>\n");

        sb.append("</body>\n");
        sb.append("</html>");

        return sb.toString();
    }
}
