package com.sales.bakery.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	private static final long RECIEPT_NUMER = 10L;

	private static final int NUMBER_OF_INVOCATIONS = 1;

	private static final int EXPECTED_SIZE_OF_LIST = 1;

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
		List<Reciept> receiptsData = new ArrayList<>();
		reciept.setRecieptNumber(RECIEPT_NUMER);
		
		receiptsData.add(reciept);
		
		when(recieptRepository.findAll()).thenReturn(receiptsData);
		
		List<Reciept> receipts = recieptRepository.findAll();
		
		assertEquals(EXPECTED_SIZE_OF_LIST, receipts.size());
		
		verify(recieptRepository, times(NUMBER_OF_INVOCATIONS)).findAll();
	}

	@Test
	public void testGetByRecieptNumber() {
		Reciept reciept = new Reciept();
		reciept.setRecieptNumber(RECIEPT_NUMER);
		
		Optional<Reciept> recieptOptional = Optional.of(reciept);
		
		when(recieptRepository.findById(anyLong())).thenReturn(recieptOptional);
		
		Reciept recieptReturned = recieptService.getByRecieptNumber(RECIEPT_NUMER);
		
		assertNotNull(recieptReturned);
		verify(recieptRepository, times(NUMBER_OF_INVOCATIONS)).findById(anyLong());
	}
}
