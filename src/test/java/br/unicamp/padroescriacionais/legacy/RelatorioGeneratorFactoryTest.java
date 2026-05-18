package br.unicamp.padroescriacionais.legacy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.unicamp.padroescriacionais.legacy.domain.FormatoRelatorio;
import br.unicamp.padroescriacionais.legacy.generator.CsvRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.PdfRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.XmlRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.HtmlRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.JsonRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.factory.RelatorioGeneratorFactory;

class RelatorioGeneratorFactoryTest {

    @Test
    void deveRetornarInstanciaCorretaParaCadaFormato() {
        assertTrue(RelatorioGeneratorFactory.criar(FormatoRelatorio.PDF) instanceof PdfRelatorioGenerator);
        assertTrue(RelatorioGeneratorFactory.criar(FormatoRelatorio.CSV) instanceof CsvRelatorioGenerator);
        assertTrue(RelatorioGeneratorFactory.criar(FormatoRelatorio.JSON) instanceof JsonRelatorioGenerator);
        assertTrue(RelatorioGeneratorFactory.criar(FormatoRelatorio.XML) instanceof XmlRelatorioGenerator);
        assertTrue(RelatorioGeneratorFactory.criar(FormatoRelatorio.HTML) instanceof HtmlRelatorioGenerator);
    }
}