import Vue from "vue";
import Vuetify from "vuetify/lib/framework";

Vue.use(Vuetify);

// 테마 컬러 variation 지정 가능
export default new Vuetify({
    theme: {
        themes: {
            light: {
                primary: "#66D49F",
                secondary: "#FFFFFF",
                accent: "#8c9eff",
                error: "#b71c1c",
                textcolor: "1E1E1E",
            },
        },
    },
});
