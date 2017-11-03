package com.sales.bakery.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import com.sales.bakery.domain.Good;
import com.sales.bakery.repositories.GoodRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BakerySalesApplication.class)
public class GoodServiceImplTest {

	private static final String GOOD_ID = "DK-04";
	private static final int EXPECTED_SIZE_OF_LIST = 1;
	private static final int NUMBER_OF_INVOCATIONS = 1;

	@Mock
	private GoodRepository goodRepository;
	
	private GoodService goodService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		goodService = new GoodServiceImpl(goodRepository);
	}

	@Test
	public void testGetAllGoods() {
		Good good = new Good();
		good.setId(GOOD_ID);
		
		List<Good> goodsData = new ArrayList<>();
		goodsData.add(good);
		
		when(goodRepository.findAll()).thenReturn(goodsData);
		
		List<Good> goods = goodRepository.findAll();
		
		assertEquals(EXPECTED_SIZE_OF_LIST, goods.size());
		
		verify(goodRepository, times(NUMBER_OF_INVOCATIONS)).findAll();
		verify(goodRepository, never()).findById(any());
		
	}

	@Test
	public void testGetByGoodId() {
		Good good = new Good();
		good.setId(GOOD_ID);
		
		Optional<Good> goodOptional = Optional.of(good);
		
		when(goodRepository.findById(any())).thenReturn(goodOptional);
		
		Good goodReturned = goodService.getByGoodId(GOOD_ID);
		
		assertNotNull(goodReturned);
		verify(goodRepository, times(NUMBER_OF_INVOCATIONS)).findById(any());
	}

}
