package menu.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printInputCoachNameMessage() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printFinalResult(Map<String, List<String>> foodRecommendedByCoaches,
                                 List<String> pickedCategories) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        makeCategoryPhrase(pickedCategories);
        printRecommendationResult(foodRecommendedByCoaches);
        System.out.println("추천을 완료했습니다.");
    }

    public void makeCategoryPhrase(List<String> pickedCategories) {
        String phrase = "";
        for (int i = 0; i < 5; i++) {
            phrase += " " + pickedCategories.get(i) + " ";

            if (i != 4) {
                phrase += "|";
            }
        }
        System.out.println("[ 카테고리 |" + phrase + "]");;
    }

    public void printRecommendationResult(Map<String, List<String>> foodRecommendedByCoaches) {
        List<String> coachName = foodRecommendedByCoaches.keySet().stream().collect(Collectors.toList());
        for (String name : coachName) {
            String phrase = "[ " + name + " |";
            for (int i = 0; i < 5; i++) {
                phrase += " " + foodRecommendedByCoaches.get(name).get(i) + " ";

                if (i != 4) {
                    phrase += "|";
                }
                if (i == 4) {
                    phrase += "]";
                }
            }
            System.out.println(phrase);
        }
    }
}
