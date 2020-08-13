package br.com.worldbank.service.implementations;

import java.io.IOException;

import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import br.com.worldbank.ViewModel.DataViewModel;

import br.com.worldbank.service.interfaces.IWorldBankService;
import br.com.worldbank.utils.Util;

@Dependent
public class WorldBankService implements IWorldBankService {

    @Inject
    Util util;

    @Override
    public List<DataViewModel> getIndicatorsByCodCountry(final String codCountry) throws IOException {

        try {
            final String url = "http://api.worldbank.org/v2/country/%s/indicator/SI.POV.DDAY?format=json";
            final String urlResult = String.format(url, codCountry);

            final URL urlForGetRequest = new URL(urlResult);

            final var returnApi = util.ConnectionGET(urlForGetRequest);

            var object = util.ConvertGsonToDataViewModel(returnApi);

            return object;

        } catch (Exception e) {
            throw e;
        }
    }

}