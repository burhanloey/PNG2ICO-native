/*
 * Copyright (C) 2015 Burhanuddin
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package png2ico.pkgnative;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import net.sf.image4j.codec.ico.ICOEncoder;

/**
 *
 * @author Burhanuddin
 */
public class MainApp {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }
        
        List<BufferedImage> inputImages = new ArrayList<>(args.length - 1);
        
        for (int i = 0; i < args.length - 1; i++) {
            File file = new File(args[i] + ".png");
            if (file.exists()) {
                BufferedImage image = ImageIO.read(file);
                if (image != null) {
                    inputImages.add(image);
                }
            } else {
                System.out.println("File " + file.getName() + " does not exist!");
                System.exit(-1);
            }
        }
        
        File outputFile = new File(args[args.length - 1] + ".ico");
        if (outputFile.getParent() != null) {
            new File(outputFile.getParent()).mkdirs();
        }
        ICOEncoder.write(inputImages, outputFile);
    }
    
}
