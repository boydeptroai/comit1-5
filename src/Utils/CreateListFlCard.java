package Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Entity.FlashCardEntity;
import Entity.PracticeFLCard;
import Model.DAO.FlashCardDAOIml;

public class CreateListFlCard {
	public List<PracticeFLCard> listFl(List<FlashCardEntity> list) {
		List<PracticeFLCard> newList = new ArrayList<PracticeFLCard>();

		for (FlashCardEntity li : list) {
			newList.add(objNew(list, li));
		}

		return newList;
	}

	public static PracticeFLCard objNew(List<FlashCardEntity> list, FlashCardEntity objDetail) {
		PracticeFLCard obj = new PracticeFLCard();

		obj.setQuestion(objDetail.getFlcard_question1());
		obj.setOptionuselect(objDetail.getFlcard_img());
		obj.setOption1(objDetail.getFlcard_img());
		List<FlashCardEntity> listRd = listRandom(list, objDetail);
		obj.setOption2(listRd.get(1).getFlcard_name());
		obj.setOption3(listRd.get(2).getFlcard_name());
		obj.setOption4(listRd.get(3).getFlcard_name());
		return obj;
	}

	public static List<FlashCardEntity> listRandom(List<FlashCardEntity> list, FlashCardEntity objDetail) {
		List<FlashCardEntity> newList = new ArrayList<FlashCardEntity>();
		newList.add(objDetail);
		while (newList.size() <= 3) {
			FlashCardEntity n = random(list);
			if (newList.contains(n)) {

			} else {
				newList.add(n);
			}
		}
		return newList;

	}

	public static FlashCardEntity random(List<FlashCardEntity> list) {
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}

	public static void main(String[] args) {
		FlashCardDAOIml f = new FlashCardDAOIml();
		CreateListFlCard c = new CreateListFlCard();
		List<FlashCardEntity> n = f.findByCategoryId(1, 0, 7);
		System.out.println("n: " + n);
		c.listFl(n);
		System.out.println(c.listFl(n));
	}
}
