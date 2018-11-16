package Inl3;


public class Mandelbrot {

    public static void main(String[] args) {

        MandelbrotGUI mb = new MandelbrotGUI();
        mb.enableInput();
        Generator gen = new Generator();

        //CircleGenerator cGen = new CircleGenerator();
        boolean hasImage = false;

        while (true) {
            int test =  mb.getCommand();

            switch (test){
                case MandelbrotGUI.RESET:
                    mb.resetPlane();
                    mb.clearPlane();
                    hasImage = false;
                    break;
                case MandelbrotGUI.QUIT:
                    System.exit(0);
                    break;
                case MandelbrotGUI.RENDER:
                    if ((!mb.getExtraText().equals("")) && (Integer.parseInt(mb.getExtraText()) <= 20000)){

                        gen.render(mb,Integer.parseInt(mb.getExtraText()));
                    }else {
                        gen.render(mb,200);
                    }

                    hasImage = true;
                    break;
                case MandelbrotGUI.ZOOM:
                    if (hasImage){
                        if ((!mb.getExtraText().equals("")) && (Integer.parseInt(mb.getExtraText()) <= 20000)){

                            gen.render(mb,Integer.parseInt(mb.getExtraText()));
                        }else {
                            gen.render(mb,200);
                        }
                        System.out.println((!mb.getExtraText().equals("")) && (Integer.parseInt(mb.getExtraText()) <= 20000));

                    }
                    break;


            }

        }
    }
}
