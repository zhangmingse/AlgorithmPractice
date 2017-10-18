package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution638 {
	public static void main(String[] args) {
		List<Integer> price_list = new ArrayList<Integer>();
		List<Integer> specialoffer1 = new ArrayList<>();
		List<Integer> specialoffer2 = new ArrayList<>();
		List<List<Integer>> special_offers = new ArrayList<>();
		List<Integer> need = new ArrayList<>();
		
		price_list.add(2);
		price_list.add(5);
		
		specialoffer1.clear();
		specialoffer1.add(3);
		specialoffer1.add(0);
		specialoffer1.add(5);
		special_offers.add(specialoffer1);

		specialoffer2.clear();
		specialoffer2.add(1);
		specialoffer2.add(2);
		specialoffer2.add(10);
		special_offers.add(specialoffer2);
		
		need.add(3);
		need.add(2);
		
		System.out.println(new Solution638().shoppingOffers(price_list,special_offers,need));
		
		price_list.clear();
		price_list.add(2);
		price_list.add(3);
		price_list.add(4);
		
		special_offers.clear();
		
		specialoffer1.clear();
		specialoffer1.add(1);
		specialoffer1.add(1);
		specialoffer1.add(0);
		specialoffer1.add(4);
		special_offers.add(specialoffer1);

		specialoffer2.clear();
		specialoffer2.add(2);
		specialoffer2.add(2);
		specialoffer2.add(1);
		specialoffer2.add(9);
		special_offers.add(specialoffer2);
		
		need.clear();
		need.add(1);
		need.add(2);
		need.add(1);
		
		System.out.println(new Solution638().shoppingOffers(price_list,special_offers,need));
	}
	
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int result = 0;
        int[] buy = new int[needs.size()];
        result = shoppingOffers_deepsearch(price, special,0, needs,buy);
        return result;
    }
    
    private int shoppingOffers_deepsearch(List<Integer> price, List<List<Integer>> special,int index, List<Integer> needs,int[] buy){
    	int result =Integer.MAX_VALUE;
    	int temp_result = 0;
    	if(index == special.size()){
    		for(int i = 0;i<needs.size();i++){
    			temp_result += (needs.get(i) - buy[i])*price.get(i);
    		}
    		result = temp_result;
    	}else{
    		List<Integer> sp = special.get(index);
    		int k = 0;
    		for(;check(sp, buy, k,needs);k++){
    			add_to_buy(buy, k, sp);
    			temp_result = shoppingOffers_deepsearch(price, special, index+1, needs, buy);
    			subtract_to_buy(buy, k, sp);
    			int current_price = temp_result + k * sp.get(sp.size()-1);
    			if(current_price  < result){
    				result = current_price;
    			}
    		}
    	}
    	
    	
    	return result;
    }
    private boolean check(List<Integer> sp,int[] buy,int k,List<Integer> needs){
    	for(int i = 0;i<needs.size();i++){
    		if(sp.get(i) * k + buy[i] > needs.get(i)){
    			return false;
    		}
    	}
    	return true;
    }
    private void add_to_buy(int[] buy,int k,List<Integer> sp){
    	for(int i = 0;i<buy.length;i++){
    		buy[i] += sp.get(i) * k;
    	}
    }
    private void subtract_to_buy(int[] buy,int k,List<Integer> sp){
    	for(int i = 0;i<buy.length;i++){
    		buy[i] -= sp.get(i) * k;
    	}
    }
    


}
