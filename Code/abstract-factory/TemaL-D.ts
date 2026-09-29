//Interfaz del producto 
interface Button {
    render(): void;
}
//Interfaz abstracta de factory (contrato principal)
interface ThemeFactory {
    createButton(): Button;
}

// Familia Claro
class LightButton implements Button {
    render() {
    console.log("Botón claro (fondo blanco)");
    }
}

class LightThemeFactory implements ThemeFactory {
    createButton(): Button {
    return new LightButton();
    }
}

// Familia Oscuro
class DarkButton implements Button {
    render() {
    console.log("Botón oscuro (fondo negro)");
    }
}

class DarkThemeFactory implements ThemeFactory {
    createButton(): Button {
    return new DarkButton();
    }
}

// Cliente: no le importa si es claro u oscuro, solo usa la fábrica
function renderUI(factory: ThemeFactory) {
    const button = factory.createButton();
    button.render();
}

// Uso:
const isDark = true;
const factory: ThemeFactory = isDark ? new DarkThemeFactory() : new LightThemeFactory();

renderUI(factory); // Imprime: "Botón oscuro (fondo negro)"