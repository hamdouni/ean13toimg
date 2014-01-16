import org.krysalis.barcode4j.impl.upcean.EAN13Bean
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider
import java.awt.image.BufferedImage

EAN13Bean bean = new EAN13Bean()

fos = new ByteArrayOutputStream(4096)

BitmapCanvasProvider canvas = new BitmapCanvasProvider(fos, "image/png", 150, BufferedImage.TYPE_BYTE_BINARY, false, 0)
bean.generateBarcode(canvas, request.getParameter('ean') )
canvas.finish()

response.setContentType("image/png")
response.setContentLength(fos.size())
response.getOutputStream().write(fos.toByteArray());