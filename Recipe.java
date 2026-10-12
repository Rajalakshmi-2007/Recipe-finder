import java.io.IOException;
import java.net.*;
import com.sun.net.httpserver.*;
import java.nio.charset.StandardCharsets;
class Recipe{
    public static void main(String[] args) throws IOException{
        HttpServer server= HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", e -> {
            String html="""
            <!DOCTYPE html>
            <html>
            <body>
            <h1>Recipe Finder</h1>
            <input id="task" placeholder="Enter recipe name">
            <button onclick="add()">Search</button>
            <ul id="list"></ul>
            <script>
                function add() {
                    let t = document.getElementById("task").value;
                    if(t === "") return;
                    else if(t.toLowerCase()=="dosa" ){
                     t="Dosa: Rice,urad dal,water,salt";    
                    }
                    else if(t.toLowerCase()=="idli" ){
                     t="Idli: Rice,urad dal,water,salt";    
                    }
                    else if (t.toLowerCase()=="vada" ){
                     t="Vada: Urad dal,water,salt";    
                    }
                    else if (t.toLowerCase()=="pongal" ){
                     t="Pongal: Rice,moong dal,water,salt";    
                    }
                    else if (t.toLowerCase()=="sambar" ){
                     t="Sambar: Toor dal,vegetables,tamarind,sambar powder";    
                    }
                    else if (t.toLowerCase()=="rasam" ){
                     t="Rasam: Tamarind, tomatoes, rasam powder";    
                    }
                    else if (t.toLowerCase()=="chutney" ){
                     t="Chutney: Coconut, green chilies, tamarind, salt";    
                    }
                    else if (t.toLowerCase()=="curd rice" ){
                     t="Curd Rice: Rice, curd, salt";    
                    }
                    else if (t.toLowerCase()=="biryani" ){
                     t="Biryani: Rice, meat/vegetables, spices";    
                    }
                    else if (t.toLowerCase()=="pulao" ){
                     t="Pulao: Rice, vegetables, spices";    
                    }
                    else if (t.toLowerCase()=="upma" ){
                     t="Upma: Semolina, water, vegetables, spices";    
                    }
                    else if (t.toLowerCase()=="cake"){
                     t="Cake: Flour, sugar, eggs, butter";    
                    }
                    else {
                    t="Recipe not found";
                    }
                    let li = document.createElement("li");
                    li.textContent = t+" ";
                    document.getElementById("list").appendChild(li);
                    document.getElementById("task").value = "";
                }
            </script>
            </body>
            </html>
            """;
            byte [] data= html.getBytes(StandardCharsets.UTF_8);
            e.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
            e.sendResponseHeaders(200, data.length);
            e.getResponseBody().write(data);
            e.close();
        });
        server.start();
        System.out.println("Open : http://localhost:8000");
    }
}