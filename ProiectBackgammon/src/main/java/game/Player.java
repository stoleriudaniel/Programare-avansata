package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

public class Player{
    private final GraphicsContext gc;
    private String name;
    protected List<Checker> checkers = new ArrayList<>();
    private Coordinates[] trianglesCoordinates = new Coordinates[24];
    private int[] triangleInitPosition;
    private int[] checkersInitNumber;
    private int[] triangleCheckers = new int[24];
    private final Dice dices[] = new Dice[4];
    private List<Checker> finishedCheckers = new ArrayList<>();
    private CheckersBox checkersBox;
    private Color color;
    private boolean current=false;
    public int currentDices=0;
    private int currentCheckersCount;
    public Player(GraphicsContext gc, List<Checker> checkers, CheckersBox checkersBox, Color color, int currentCheckersCount, boolean current){
        this.gc=gc;
        this.checkers=checkers;
        this.checkersBox=checkersBox;
        this.color=color;
        this.current=current;
        this.currentCheckersCount=currentCheckersCount;
    }

    public Player(GraphicsContext gc, int[] triangleInitPosition, int[] checkersInitNumber, CheckersBox checkersBox, Color color, int currentCheckersCount, boolean current) {
        this.triangleInitPosition = triangleInitPosition;
        this.checkersInitNumber = checkersInitNumber;
        this.gc = gc;
        this.checkersBox = checkersBox;
        this.color = color;
        this.current = current;
        this.currentCheckersCount=currentCheckersCount;
    }

    protected void createCheckers()
    {
        initListCheckers();
        initCheckersCoordinates();
    }

    protected void initListCheckers ()
    {
        for(int indexCheckersNumber=0; indexCheckersNumber<checkersInitNumber.length; indexCheckersNumber++) {
            for (int checkerIndex = 0; checkerIndex < checkersInitNumber[indexCheckersNumber]; checkerIndex++) {
                Checker checker = new Checker(triangleInitPosition[indexCheckersNumber], color);
                triangleCheckers[triangleInitPosition[indexCheckersNumber]-1]++;
                checkers.add(checker);
            }
        }
    }

    public Checker getCheckerClicked(double x, double y) {
        for(Checker checker : checkers) {
            if(checker.contains(x,y)) {
                System.out.println();
                System.out.println();
                System.out.println("checkerNo="+checker.getCheckerNo());
                System.out.println("TriangleNo="+checker.getTriangleNo());
                return checker;
            }
        }
        return new Checker();
    }

    public boolean isOpponentColumn(Player player, Checker checker){
        //printTriangleCheckers();
        int value = checker.getTriangleNo() - 1 - player.getCurrentDice().getValueDice();
        if(!(value>= 0))
        {
            return false;
        }
        System.out.println("isOpponentColumn:");
        System.out.println("trianglesChekers["+(value)+"]="+triangleCheckers[value]);
        System.out.println("checker.getTriangleNo()="+checker.getTriangleNo());
        System.out.println("player.getCurrentDice.getValueDice()="+player.getCurrentDice().getValueDice());
        return triangleCheckers[value]>0;
    }

    public void printTriangleCheckers()
    {
        for(int i=0;i<triangleCheckers.length;i++)
        {
            System.out.println("print: triangleCheckers["+i+"]="+triangleCheckers[i]+", color:"+((this.color==Color.GRAY) ? "Gray" : "Black"));
        }
    }

    public boolean canMoveToOpponentColumn(Player player, Checker checker){
        //printTriangleCheckers();
        int value = checker.getTriangleNo() - 1 - player.getCurrentDice().getValueDice();
        if(!(value >= 0))
        {
            return false;
        }
        System.out.print("canMoveToOpponentColumn:");
        System.out.println("trianglesChekers["+(value)+"]="+triangleCheckers[value]);
        System.out.println("getCurrentDice.getValueDice()="+player.getCurrentDice().getValueDice());
        System.out.println("checker.getTriangleNo()="+checker.getTriangleNo());
        if(triangleCheckers[value] == 0)
        {
            return true;
        }
        return false;
    }

    public boolean canMove(Checker checker, Player player){
        //printTriangleCheckers();
        int value=checker.getTriangleNo() - 1 - player.getCurrentDice().getValueDice();
        if(value < 0)
        {
            return true;
        }
        System.out.print("canMove:");
        System.out.println("trianglesChekers["+(value)+"]="+triangleCheckers[value]);
        System.out.println("getCurrentDice.getValueDice()="+player.getCurrentDice().getValueDice());
        System.out.println("checker.getTriangleNo()="+checker.getTriangleNo());
        if(triangleCheckers[value] < 5)
        {
            return true;
        }
        return false;
    }

    public boolean isClickOnChecker(double x, double y){
        for(Checker checker : checkers) {
            if(checker.contains(x,y)) {
                System.out.println();
                System.out.println();
                System.out.println("checkerNo="+checker.getCheckerNo());
                System.out.println("TriangleNo="+checker.getTriangleNo());
                //moveChecker(checker);
                return true;
            }
        }
        return false;
    }

    public CheckersBox getCheckersBox() {
        return checkersBox;
    }

    public void moveChecker(Checker checker) {
        if(triangleCheckers[checker.getTriangleNo()-1] == checker.getCheckerNo())
        {
            System.out.println("Este varf");
        }
        else{
            System.out.println("Nu este varf");
            return;
        }
        int diceIndex=getCurrentDice().getIndex();
        if(checker.getTriangleNo() - dices[diceIndex].getValueDice()>=1)
        {
            if(triangleCheckers[checker.getTriangleNo() - 1 - dices[diceIndex].getValueDice()]<5)
            {
                System.out.println("Se poate muta pe alt triunghi");
                triangleCheckers[checker.getTriangleNo()-1]--;
                triangleCheckers[checker.getTriangleNo() - 1 - dices[diceIndex].getValueDice()]++;
                checker.setTriangleNo(checker.getTriangleNo() - dices[diceIndex].getValueDice());
                checker.setCheckerNo(triangleCheckers[checker.getTriangleNo()-1]);
                //set new coords
                double x=trianglesCoordinates[checker.getTriangleNo()-1].x+trianglesCoordinates[checker.getTriangleNo()-1].width/2;
                double y=0; double offset=0;
                if(checker.getTriangleNo()<=12) {
                    y = trianglesCoordinates[checker.getTriangleNo()-1].y + trianglesCoordinates[checker.getTriangleNo()-1].height - Checker.getRadius() - 1;
                    offset = Checker.getRadius() * 2 * -1;
                }
                else {
                    y = trianglesCoordinates[checker.getTriangleNo()-1].y + Checker.getRadius() + 1;
                    offset = Checker.getRadius() * 2;
                }
                y = y + offset * (checker.getCheckerNo()-1);
                checker.setCoordinates(new Coordinates(x, y, trianglesCoordinates[checker.getTriangleNo()-1].width, trianglesCoordinates[checker.getTriangleNo()-1].height));
                drawChecker(checker);
                System.out.println("HERE: checker.getCheckerNo()="+checker.getCheckerNo());
                System.out.println("HERE: checker.getTriangleNo()="+checker.getTriangleNo());
            }
            else {
                System.out.println("NU se poate muta pe alt triunghi");
            }
        }
        else {
            System.out.println("Limit");
            triangleCheckers[checker.getTriangleNo()-1]--;
            Checker checker1 = new Checker(color);
            checkersBox.addChecker(checker1);
            checkers.remove(checker);
            currentCheckersCount--;
        }
    }

    public void reverseCheckers() {
        for(Checker checker : checkers) {
            checker.setTriangleNo(24-checker.getTriangleNo()+1);
        }
        for(int triangleIndex=0; triangleIndex<12; triangleIndex++)
        {
            int auxFrecv=triangleCheckers[triangleIndex];
            triangleCheckers[triangleIndex]=triangleCheckers[23-triangleIndex];
            triangleCheckers[23-triangleIndex]=auxFrecv;
            initCheckersCoordinates();
        }
    }

    public void initCheckersCoordinates()
    {
        for(int triangle=0;triangle<24;triangle++)
        {
            double x, y, offset; int checkerNo=0;
            for(Checker checker : checkers) {
                x=trianglesCoordinates[checker.getTriangleNo()-1].x+trianglesCoordinates[checker.getTriangleNo()-1].width/2;
                if(checker.getTriangleNo()==triangle+1) {
                    if(checkerNo<triangleCheckers[triangle]) {
                        if(triangle<12) {
                            y = trianglesCoordinates[checker.getTriangleNo()-1].y + trianglesCoordinates[checker.getTriangleNo()-1].height - Checker.getRadius() - 1;
                            offset = Checker.getRadius() * 2 * -1;
                            y = y + offset * checkerNo;
                            checker.setCoordinates(new Coordinates(x, y, trianglesCoordinates[checker.getTriangleNo()-1].width, trianglesCoordinates[checker.getTriangleNo()-1].height));
                            checkerNo++;
                            checker.setCheckerNo(checkerNo);
                        }
                        else {
                            y = trianglesCoordinates[checker.getTriangleNo()-1].y + Checker.getRadius() + 1;
                            offset = Checker.getRadius() * 2;
                            y = y + offset * checkerNo;
                            checker.setCoordinates(new Coordinates(x, y, trianglesCoordinates[checker.getTriangleNo()-1].width, trianglesCoordinates[checker.getTriangleNo()-1].height));
                            checkerNo++;
                            checker.setCheckerNo(checkerNo);
                        }
                    }
                }
            }
        }
    }

    protected void drawCheckers() {
        for(Checker checker : checkers) {
            drawChecker(checker);
        }
    }

    public void drawChecker(Checker checker){
        checker.drawOval(gc,checker.getCoordinates().x,checker.getCoordinates().y);
    }

    public void initDices(){
        int offset=0;
        for(int i=0;i<2;i++) {
            dices[i] = new Dice(color);
            dices[i].setCoordinates(new Coordinates(150+offset,300,50,50));
            dices[i].setDiceRandomValue();
            dices[i].setIndex(i);
            offset+=70;
            currentDices=2;
        }
        if(dices[0].getValueDice()==dices[1].getValueDice()) {
            for(int i=2;i<4;i++) {
                dices[i] = new Dice(color);
                dices[i].setCoordinates(new Coordinates(150+offset,300,50,50));
                dices[i].setValueDice(dices[0].getValueDice());
                dices[i].setIndex(i);
                offset+=70;
                currentDices=4;
            }
        }
        dices[0].setCurrent(true);
        dices[0].drawMark(gc);
    }

    public boolean existsNextDice()
    {
        for(int index=0; index<currentDices - 1; index++)
        {
            if(dices[index].isCurrent()){
                return true;
            }
        }
        dices[currentDices-1].setCurrent(false);
        return false;
    }

    public void setNextDiceToCurrent(){
        int index=0;
        while(!dices[index].isCurrent())
        {
            index++;
        }
        dices[index].setCurrent(false);
        dices[index+1].setCurrent(true);
        dices[index+1].drawMark(gc);
    }

    public void drawDices() {
        for(int i=0;i<currentDices;i++)
        {
            dices[i].draw(gc);
        }
    }

    public void setTrianglesCoordinates(Coordinates[] trianglesCoordinates) {
        this.trianglesCoordinates = trianglesCoordinates;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public boolean isCurrent() {
        return current;
    }

    public Dice getCurrentDice()
    {
        boolean found=false;
        int i=0;
        while(i<currentDices && !found) {
            if (dices[i].isCurrent()) {
                found=true;
                break;
            }
            i++;
        }
        return dices[i];
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public int getCheckersCount()
    {
        return checkers.size();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrentCheckersCount() {
        return currentCheckersCount;
    }
}
