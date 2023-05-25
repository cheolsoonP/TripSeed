<template>
  <div>
    <v-card height="400" width="256" class="mx-auto">
      <v-navigation-drawer permanent>
        <v-card class="mx-auto" elevation="0">
          <v-list>
            <v-list-item link @click="scrollTo('coming-plan')">
              <v-list-item-title> 다가오는 여행 </v-list-item-title>
            </v-list-item>

            <v-divider />

            <v-list-group :value="true">
              <template v-slot:activator>
                <v-list-item-title>나의 여행</v-list-item-title>
              </template>

              <v-list-item link @click="scrollTo('my-current')">
                <v-list-item-title>여행 계획</v-list-item-title>
              </v-list-item>
              <v-list-item link @click="scrollTo('my-past')">
                <v-list-item-title>지난 일정</v-list-item-title>
              </v-list-item>
            </v-list-group>

            <v-divider />

            <v-list-group
              :value="false"
             @click="showSnackbar('To be Continued...🙄')"
            >
              <template v-slot:activator>
                <v-list-item-title>참여한 여행</v-list-item-title>
              </template>
<!-- 
              <v-list-item link>
                <v-list-item-title>여행 계획</v-list-item-title>
              </v-list-item>
              <v-list-item link>
                <v-list-item-title>지난 일정</v-list-item-title>
              </v-list-item> -->
            </v-list-group>
          </v-list>
        </v-card>
      </v-navigation-drawer>
    </v-card>

    <v-snackbar
      v-model="snackbar.show"
      :color="snackbar.color"
      :timeout="snackbar.timeout"
      >{{ snackbar.message }}</v-snackbar
    >
  </div>
</template>

<script>
// import { mapActions, mapState } from "vuex"

// const planStore = "planStore";

export default {
  name: "PlanSideBar",
  data() {
    return {
      snackbar: {
        show: false,
        message: "",
        color: "",
        timeout: 1000,
      },
    };
  },
  computed: {
    // ...mapState(planStore, [""]),
    target() {
      /* 
      target can be pixel offset from the top 
      or css selector, or an element reference.
    */
      const value = this[this.type];
      if (!isNaN(value)) return Number(value);
      else return value;
    },
    options() {
      return {
        duration: this.duration,
        offset: this.offset,
        easing: this.easing,
      };
    },
    element() {
      if (this.selected === "Button") return this.$refs.button;
      else if (this.selected === "Radio group") return this.$refs.radio;
      else return null;
    },
  },
  methods: {
    // ...mapActions(planStore, [""]),
    scrollTo(id) {
      const element = document.getElementById(id);
      if (element) {
        element.scrollIntoView({ behavior: "smooth" });
        element.style.color = "#66d49F";

        setTimeout(() => {
          element.style.color = "";
        }, 500);
      } else {
        this.showSnackbar("일정이 없어요 :)");
      }
    },
    showSnackbar(message) {
      this.snackbar.message = message;
      this.snackbar.color = "#66d49F";
      this.snackbar.show = true;
    },
  },
};
</script>

<style></style>
