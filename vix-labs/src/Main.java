import fifth_lab.FifthLab;
import fourth_lab.FourthLab;
import second_lab.SecondLab;
import core.Command;
import first_lab.FirstLab;
import sixth_lab.SixthLab;
import third_lab.ThirdLab;

public class Main {
    public static void main(String[] args) {
        final Command[] labs = {
                new FirstLab(),
                new SecondLab(),
                new ThirdLab(),
                new FourthLab(),
                new FifthLab(),
                new SixthLab()
        };

        for (Command lab: labs) {
            lab.execute();
        }
    }
}
