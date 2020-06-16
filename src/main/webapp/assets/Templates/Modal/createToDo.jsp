<%@ page import="java.util.ArrayList" %>
<jsp:useBean id="test" class="beans.ToDoBean"></jsp:useBean>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Neue Aufgabe erstellen</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Aufgabe eingeben
            </div>
            <form action="addTodoLogic" method="POST">
                <label for="todo" class="sr-only">Aufgabe</label>
                <input id="todo" class="form-control" placeholder="Neue Aufgabe erstellen" name="todo" type="text" required>
                <label for="name" class="sr-only">Name</label>
                <select id="name" class="form-control" name="name" required>
                    <%
                        Cookie cookiez = null;
                        Cookie[] cookiesz = null;
                        String valuez = "";
                        // Get an array of Cookies associated with the this domain
                        cookiesz = request.getCookies();
                        ArrayList<String> allMember = new ArrayList<String>();

                        if( cookiesz != null ) {
                            for (int i = 0; i < cookiesz.length; i++) {
                                cookiez = cookiesz[i];
                                if ((cookiesz[i].getName().compareTo("session")) == 0){
                                    valuez = cookiesz[i].getValue();
                                    allMember = (ArrayList<String>) test.getAllUsersOfWgBySessionIdentifier(valuez);
                                    for (String item : allMember)
                                    {
                                        out.print("<option value=\""+item+"\">"+test.getNameString(item)+"</option>");
                                    }
                                }
                            }
                        } else {
                            out.println("<h2>No cookies founds</h2>");
                        }
                    %>
                </select>
                <label for="deadline" class="sr-only">Deadline</label>
                <input id="deadline" class="form-control" placeholder="Deadline" name="deadline" type="date" required>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary odom-submit">ToDo erstellen</button>
                </div>
            </form>
        </div>
    </div>
</div>