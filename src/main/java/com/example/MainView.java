package com.example;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Reserva de libros")
@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        setSizeFull();
        setPadding(true);
        setSpacing(true);

        H2 titulo = new H2("Sistema de reserva de libros");

        TabSheet tabSheet = new TabSheet();
        tabSheet.setWidthFull();

        tabSheet.add("Libros", crearSeccionEntidad1());
        tabSheet.add("Usuario", crearSeccionEntidad2());

        add(titulo, tabSheet);
    }

    // Método privado para gestionar la primera entidad
    private Component crearSeccionEntidad1() {
        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(false);

        TextField idField = new TextField("ID del libro");
        TextField tituloField = new TextField("Titulo del libro");
        TextField autorField = new TextField(" Autor");
        TextField editorialField = new TextField("Editorial");
        TextField categoriaField = new TextField("Categoria");

        FormLayout form = new FormLayout(idField, tituloField, autorField, editorialField, categoriaField);

        Button btnCrear = new Button("Crear", e -> 
            Notification.show("Libro 1 - Crear: " + tituloField.getValue())
        );
        btnCrear.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button btnConsultar = new Button("Consultar", e -> 
            Notification.show("Libro 1 - Consultar ID: " + idField.getValue())
        );

        Button btnActualizar = new Button("Actualizar", e -> 
            Notification.show("Libro 1 - Actualizar ID: " + idField.getValue())
        );

        Button btnEliminar = new Button("Eliminar", e -> 
            Notification.show("Libro 1 - Eliminar ID: " + idField.getValue())
        );
        btnEliminar.addThemeVariants(ButtonVariant.LUMO_ERROR);

        Button btnLimpiar = new Button("Limpiar", e -> {
            idField.clear();
            tituloField.clear();
            autorField.clear();
            editoriallField.clear();
            categoriaField.clear();
        });

        HorizontalLayout acciones = new HorizontalLayout(
            btnCrear, btnConsultar, btnActualizar, btnEliminar, btnLimpiar
        );
        acciones.getStyle().set("flex-wrap", "wrap");

        Grid<String[]> grid = new Grid<>();
        grid.addColumn(row -> row[0]).setHeader("ID del libro").setAutoWidth(true);
        grid.addColumn(row -> row[1]).setHeader("Titulo del libro").setAutoWidth(true);
        grid.addColumn(row -> row[2]).setHeader("Autor").setAutoWidth(true);
        grid.addColumn(row -> row[3]).setHeader("Editorial").setAutoWidth(true);
        grid.addColumn(row -> row[4]).setHeader("Categoria").setAutoWidth(true);

        layout.add(form, acciones, grid);
        return layout;
    }

    // Método privado para gestionar la segunda entidad
    private Component crearSeccionEntidad2() {
        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(false);

        TextField idField = new TextField("ID del usuario");
        TextField nombreField = new TextField("Nombre del usuario");
        TextField emailField = new TextField("Correo electronico");
        TextField tipoUsuarioField = new TextField("Tipo de usuario");

        FormLayout form = new FormLayout(idField, nombreField, emailField, tipoUsuarioField);

        Button btnCrear = new Button("Crear", e -> 
            Notification.show("Usuario 2 - Crear: " + nombreField.getValue())
        );
        btnCrear.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button btnConsultar = new Button("Consultar", e -> 
            Notification.show("Usuario 2 - Consultar Código: " + idField.getValue())
        );

        Button btnActualizar = new Button("Actualizar", e -> 
            Notification.show("Usuario 2 - Actualizar Código: " + idField.getValue())
        );

        Button btnEliminar = new Button("Eliminar", e -> 
            Notification.show("Usuario 2 - Eliminar Código: " + idField.getValue())
        );
        btnEliminar.addThemeVariants(ButtonVariant.LUMO_ERROR);

        Button btnLimpiar = new Button("Limpiar", e -> {
            idField.clear();
            nombreField.clear();
            emailField.clear();
            tipoUsuarioField.clear();
        });

        HorizontalLayout acciones = new HorizontalLayout(
            btnCrear, btnConsultar, btnActualizar, btnEliminar, btnLimpiar
        );
        acciones.getStyle().set("flex-wrap", "wrap");

        Grid<String[]> grid = new Grid<>();
        grid.addColumn(row -> row[0]).setHeader("ID del usuario").setAutoWidth(true);
        grid.addColumn(row -> row[1]).setHeader("Nombre del usuario").setAutoWidth(true);
        grid.addColumn(row -> row[2]).setHeader("Corro electronico").setAutoWidth(true);
        grid.addColumn(row -> row[3]).setHeader("Tipo de usuario").setAutoWidth(true);

        layout.add(form, acciones, grid);
        return layout;
    }
}
