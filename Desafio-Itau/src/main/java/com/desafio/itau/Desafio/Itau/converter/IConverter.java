package com.desafio.itau.Desafio.Itau.converter;

public interface IConverter<FROM, TO> {
    TO toEntity(FROM dto);
}
