package gt.com.edu.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;

import com.lowagie.text.pdf.PdfWriter;

import gt.com.edu.models.entity.Calificacion;


@Component("api/calificaciones/listar")
public class ListarCalificacionesPdf extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<Calificacion> listarCalificaciones=(List<Calificacion>) model.get("calificaciones");
		
		
		
		
		PdfPTable tablaCalificaciones= new PdfPTable(9);
		
		
		listarCalificaciones.forEach(calificacion ->{
			
			tablaCalificaciones.addCell(calificacion.getEstudiante().getPrimer_nombre_estudiante());
			tablaCalificaciones.addCell(calificacion.getEstudiante().getPrimer_apellido_estudiante());
			tablaCalificaciones.addCell(calificacion.getCurso().getNombre_curso());
			tablaCalificaciones.addCell(calificacion.getId().toString());
			tablaCalificaciones.addCell(calificacion.getNota_bim1().toString());
			tablaCalificaciones.addCell(calificacion.getNota_bim2().toString());
			tablaCalificaciones.addCell(calificacion.getNota_bim3().toString());
			tablaCalificaciones.addCell(calificacion.getNota_bim4().toString());
			tablaCalificaciones.addCell(calificacion.getPromedio_final().toString());
			
		});
		
		document.add(tablaCalificaciones);
	}

}
