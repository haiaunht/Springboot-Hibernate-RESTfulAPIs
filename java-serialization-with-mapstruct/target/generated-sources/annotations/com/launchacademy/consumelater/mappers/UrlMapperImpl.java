package com.launchacademy.consumelater.mappers;

import com.launchacademy.consumelater.dto.UrlDto;
import com.launchacademy.consumelater.models.Url;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-15T13:51:47-0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.9 (Oracle Corporation)"
)
@Component
public class UrlMapperImpl implements UrlMapper {

    @Override
    public UrlDto urlToUrlDto(Url url) {
        if ( url == null ) {
            return null;
        }

        UrlDto urlDto = new UrlDto();

        urlDto.setContentType( url.getMediaType() );
        urlDto.setId( url.getId() );
        urlDto.setUrl( url.getUrl() );
        urlDto.setDescription( url.getDescription() );

        return urlDto;
    }

    @Override
    public List<UrlDto> urlsToUrlDtos(List<Url> urls) {
        if ( urls == null ) {
            return null;
        }

        List<UrlDto> list = new ArrayList<UrlDto>( urls.size() );
        for ( Url url : urls ) {
            list.add( urlToUrlDto( url ) );
        }

        return list;
    }
}
