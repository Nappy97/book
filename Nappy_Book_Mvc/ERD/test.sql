-- 기본데이터 삽입
INSERT INTO exam_book
	(bk_title, bk_summary, bk_price)
VALUES
	('불편한 편의점', '한층 진득해진 이야기와 궁금증 가득한 캐릭터, 고난의 시간을 통과하는 사람들이 다시 편의점에 모여든다!', '12600'),
	('하얼빈','『하얼빈』에서는 단순하게 요약되기 쉬운 실존 인물의 삶을 역사적 기록보다도 철저한 상상으로 탄탄하게 재구성하는 김훈의 글쓰기 방식이 빛을 발한다', '14400')
;


SELECT * FROM exam_book  ORDER BY bk_id  DESC;