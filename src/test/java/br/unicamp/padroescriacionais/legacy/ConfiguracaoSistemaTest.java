package br.unicamp.padroescriacionais.legacy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.unicamp.padroescriacionais.legacy.domain.ConfiguracaoSistema;
import br.unicamp.padroescriacionais.legacy.service.ConfiguracaoService;

class ConfiguracaoSistemaTest {

    @BeforeEach
    void setUp() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstancia();
        config.setNomeEmpresa("UNICAMP");
        config.setAmbiente("DEV");
        config.setDiretorioExportacao("/tmp/test");
        config.setDebugAtivo(true);
    }

    @Test
    void deveRetornarMesmaInstanciaSempre() {
        ConfiguracaoSistema config1 = ConfiguracaoSistema.getInstancia();
        ConfiguracaoSistema config2 = ConfiguracaoSistema.getInstancia();

        assertSame(config1, config2);
    }

    @Test
    void devePermitirAlteracaoDeAmbiente() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstancia();
        config.setAmbiente("PROD");

        assertEquals("PROD", config.getAmbiente());
    }

    @Test
    void devePermitirAlteracaoDeDebug() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstancia();
        config.setDebugAtivo(false);

        assertFalse(config.isDebugAtivo());
    }

    @Test
    void devePermitirAlteracaoDeDiretorio() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstancia();
        config.setDiretorioExportacao("/novo/diretorio");

        assertEquals("/novo/diretorio", config.getDiretorioExportacao());
    }

    @Test
    void alteracaoEmUmaReferenciaDeveRefletirNaOutra() {
        ConfiguracaoSistema config1 = ConfiguracaoSistema.getInstancia();
        ConfiguracaoSistema config2 = ConfiguracaoSistema.getInstancia();

        config1.setAmbiente("HML");

        assertEquals("HML", config2.getAmbiente());
    }

    @Test
    void configuracaoServiceDeveRetornarInstanciaSingleton() {
        ConfiguracaoService service = new ConfiguracaoService();
        ConfiguracaoSistema configSingleton = ConfiguracaoSistema.getInstancia();

        assertSame(configSingleton, service.getConfiguracao());
    }
}