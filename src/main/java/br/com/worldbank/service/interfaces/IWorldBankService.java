package br.com.worldbank.service.interfaces;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.annotation.Resource;

import br.com.worldbank.ViewModel.DataViewModel;
import br.com.worldbank.ViewModel.ObjectReturnViewModel;

@Resource
public interface IWorldBankService {
    
    List<DataViewModel> getIndicatorsByCodCountry(String codCountry) throws IOException;

}