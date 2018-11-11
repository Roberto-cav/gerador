package br.com.Gerador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;




public class GeraController {

	public void geraController(String tabela)  throws IOException {

		Util utl = new Util();
		
		String path = "/temp/";
		String classe = tabela;
		String objeto = "";
		classe = utl.setInitCap(classe);
		classe = utl.setSublinhadoOff(classe);
		classe = utl.retornaSingular(classe);
		objeto = classe;
		classe = classe + "Controller";
		
		path = path + classe + ".java";

		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		bw.append("package br.com.oper21.x"  + "\n");
		bw.newLine();
		bw.newLine();

		// imports
		bw.append("import org.springframework.beans.propertyeditors.CustomDateEditor;");
		bw.newLine();
		bw.append("import org.springframework.web.bind.WebDataBinder;");
		bw.newLine();
		bw.append("import org.springframework.web.bind.annotation.RequestMapping;");
		bw.newLine();
		bw.append("import org.springframework.web.servlet.ModelAndView;");
		bw.newLine();
		bw.append("import org.springframework.web.bind.annotation.ModelAttribute;");
		bw.newLine();
		bw.append("import org.springframework.web.bind.annotation.RequestMethod;");
		bw.newLine();
		bw.append("import java.text.SimpleDateFormat;");
		bw.newLine();
		bw.append("import java.util.Date;");
		bw.newLine();
		bw.newLine();
		bw.append("// Atualizar imports" + "\n");
		bw.newLine();
		bw.newLine();
		
		// cabeçalho da classe
		bw.append("@Controller");
		bw.newLine();
		bw.append("public class "+ classe +"{" + "\n");
		bw.newLine();
		bw.newLine();
		bw.append("   void initBinder(WebDataBinder webDataBinder) { ");
		bw.newLine();
		bw.append("      SimpleDateFormat dateFormat = new SimpleDateFormat('dd-MM-yyyy');");
		bw.newLine();
		bw.append("      dateFormat.setLenient(false);");
		bw.newLine();
		bw.append("      webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));");
		bw.newLine();
		bw.append("   ) ");
		bw.newLine();
		bw.newLine();
		bw.append("   @Autowired(required=false)");
		bw.newLine();
		bw.append("   private "+objeto+"DAO "+objeto.toLowerCase()+"DAO;" );
		bw.newLine();
		bw.newLine();
		bw.append("   // *** Incluir outros DAOs");
		bw.newLine();
		bw.newLine();
		bw.append("   // *** Incluir Listas");
		bw.newLine();
		bw.newLine();
		
		// método de entrada da classe
		bw.append("   @RequestMapping(value = '/"+objeto.toLowerCase()+"s')");
		bw.newLine();
		bw.append("   public ModelAndView "+objeto.toLowerCase()+"s(ModelAndView model) { ");
		bw.newLine();
		bw.newLine();
		bw.append("      "+objeto+" "+objeto.toLowerCase()+" = new "+objeto+"();");
		bw.newLine();
		bw.newLine();
		bw.append("      model.addObject('"+objeto.toLowerCase()+"', "+objeto.toLowerCase()+");");
		bw.newLine();
		bw.append("      model.setViewName=('"+objeto.toLowerCase()+"/Startup"+objeto+"');");
		bw.newLine();
		bw.newLine();
		bw.append("      return model;");
		bw.newLine();
		bw.newLine();
		bw.append("   }");
		bw.newLine();
		bw.newLine();
		
		// método de ação da classe de entrada
		bw.append("   @RequestMapping(value = '/actionStartup"+objeto+"s')");
		bw.newLine();
		bw.append("   public ModelAndView actionStartup"+objeto+"s("+objeto + " " + objeto.toLowerCase()+ ") {" );
		bw.newLine();
		bw.newLine();
		bw.append("      ModelAndView model = new ModelAndView();");
		bw.newLine();
		bw.newLine();
		bw.append("		// decidir as ações lógicas e setar o valor da viewName");
		bw.newLine();
		bw.newLine();
		bw.append("      model.addObject('"+objeto.toLowerCase()+"', "+objeto.toLowerCase()+");");
		bw.newLine();
		bw.append("      model.setViewName=('"+objeto.toLowerCase()+"/Startup"+objeto+"');");
		bw.newLine();
		bw.newLine();
		bw.append("      return model;");
		bw.newLine();
		bw.newLine();
		bw.append("   }");
		bw.newLine();
		bw.newLine();
		
		// método de lista da classe
		bw.append("   @RequestMapping(value = '/lista"+objeto + "', method = RequestMethod.POST)");
		bw.newLine();
		bw.append("   public ModelAndView pesquisa"+objeto+"(@ModelAttribute('"+objeto.toLowerCase()+"') "+objeto+"  "+objeto.toLowerCase()+") { ");
		bw.newLine();
		bw.newLine();
		bw.append("      List<"+objeto+"> lista"+objeto+";");
		bw.newLine();
		bw.newLine();
		bw.append("      // *** Incluir lógica relacionada à lista ***");

		bw.newLine();
		bw.newLine();
		bw.append("      model.addObject('lista"+objeto+"', lista"+objeto+");");
		bw.newLine();
		bw.append("      model.setViewName=('"+objeto.toLowerCase()+"/Lista"+objeto+"');");
		bw.newLine();
		bw.newLine();
		bw.append("      return model;");
		bw.newLine();
		bw.newLine();
		bw.append("   }");
		bw.newLine();
		bw.newLine();
		
		// método para inclusão de novo registor 
		bw.append("   @RequestMapping(value = '/novo"+objeto + "', method = RequestMethod.POST)");
		bw.newLine();
		bw.append("   public ModelAndView novo"+objeto+"(@ModelAttribute('"+objeto.toLowerCase()+"') "+objeto+"  "+objeto.toLowerCase()+",  BindingResult result) { ");
		bw.newLine();
		bw.newLine();
		bw.append("     "+objeto+" "+objeto.toLowerCase()+" = new "+objeto+"();");
		bw.newLine();
		bw.newLine();
		bw.append("     model.addObject('"+objeto.toLowerCase()+"', "+objeto.toLowerCase()+");");
		bw.newLine();
		bw.append("     model.setViewName=('"+objeto.toLowerCase()+"/"+objeto+"Form');");
		bw.newLine();
		bw.newLine();
		bw.append("     return model;");
		bw.newLine();
		bw.newLine();
		bw.append("   }");
		bw.newLine();
		bw.newLine();
		
		
		
		bw.close();
	}
	
}
