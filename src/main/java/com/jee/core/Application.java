package com.jee.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.util.ErrorHandler;

import javax.jms.ConnectionFactory;

/**
 * Created by Geoffrey on 26.06.2018
 */
@SpringBootApplication
@EnableJms
public class Application {

    /**
     */
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    /**
     * Create of a jms factory to construct the jms queue
     *
     * @param connectionFactory the configuration factory to set
     * @param configurer        launch configuration
     * @return the configuration factory
     */
    @Bean
    public JmsListenerContainerFactory<?> myFactory(final ConnectionFactory connectionFactory,
                                                    final DefaultJmsListenerContainerFactoryConfigurer configurer) {
        log.debug("connectionFactory: {}, configurer: {}", connectionFactory, configurer);

        final DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

        factory.setErrorHandler(
                new ErrorHandler() {
                    @Override
                    public void handleError(Throwable t) {
                        System.err.println("An error has occurred in the transaction");
                    }
                });

        // lambda function
        factory.setErrorHandler(t -> System.err.println("An error has occurred in the transaction"));

        // This provides all boot's default to this factory, including the message converter
        configurer.configure(factory, connectionFactory);
        // You could still override some of Boot's default if necessary.
        return factory;
    }

    /**
     * Serialize message content to json using TextMessage
     *
     * @return a message converted
     */
    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        final MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");

        return converter;
    }

    /**
     * Launch the application
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
