package com.sales.bakery.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sales.bakery.BakerySalesApplication;
import com.sales.bakery.domain.Reciept;
import com.sales.bakery.repositories.RecieptRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BakerySalesApplication.class)
public class RecieptServiceImplTest {
	
	@Mock
	private RecieptRepository recieptRepository;
	
	RecieptServiceImpl recieptService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(recieptRepository);
		recieptService = new RecieptServiceImpl(recieptRepository);
	}

	@Test
	public void testGetAllReciepts() {
		Reciept reciept = new Reciept();
		List<Reciept> reciepts = new ArrayList<>();
		reciept.setRecieptNumber(10L);
		
		reciepts.add(reciept);
		
		when(recieptRepository.findAll()).thenReturn(reciepts);
		
		assertEquals(1, reciepts.size());
		
		verify(recieptRepository, times(1)).findAll();
	}

}
