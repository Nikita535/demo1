//package com.example.demo.EntityServiceTest;
//
//import com.example.demo.Service.ImplService.ImplManufactureService;
//import com.example.demo.Service.ManufactureService;
//import com.example.demo.entity.Manufacture;
//import com.example.demo.repositoies.ManufactureRep;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Captor;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//
//
//@ExtendWith(MockitoExtension.class)
//public class ImplManufactureServiceTest {
//
//    @Mock
//    private ManufactureRep manufactureRep;
//
//    @Test
//    public void getManufacture(){
//        Manufacture manufacture1 = new Manufacture();
//        manufacture1.setName("apple");
//        Manufacture manufacture2 = new Manufacture();
//        manufacture2.setName("samsung");
//        manufactureRep.save(manufacture1);
//        manufactureRep.save(manufacture2);
//
//        Mockito.when(manufactureRep.findAll()).thenReturn(List.of(manufacture1, manufacture2));
//        ManufactureService manufactureService = new ImplManufactureService(manufactureRep);
//
////        Assertions.assertEquals(2, manufactureService.showAllManufacture().size());
//        Assertions.assertEquals("apple", manufactureService.showAllManufacture().get(0).getAddress());
//    };
//
//    @Captor
//    ArgumentCaptor<Manufacture> captor;
//
//    @Test
//    public void saveOrUpdate() {
//        Manufacture manufacture=new Manufacture();
//        manufacture.setName("apple");
//        ManufactureService manufactureService = new ImplManufactureService(manufactureRep);
//        manufactureService.saveOrUpdate(manufacture);
//        Mockito.verify(manufactureRep).save(captor.capture());
//        Manufacture captured = captor.getValue();
//        Assertions.assertEquals("apple", captured.getName());
//    }
//
//}
