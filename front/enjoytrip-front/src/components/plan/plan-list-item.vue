<template>
  <div>
    <v-card class="ma-3" width="100%" height="auto" tile :to="'/plan/view/' + planInfo.planId" >
      <v-list-item>
        <v-col cols="3">
          <v-list-item-avatar tile size="200">
            <v-img :src="planInfo.image" contain></v-img>
          </v-list-item-avatar>
        </v-col>
        <v-spacer></v-spacer>
        <v-col cols="8">
          <v-list-item-content>
            <v-list-item>
              <div class="primary rounded-pill px-3 py-1">
                <span>{{planInfo.startDate}}</span>
                <span class="mx-3">-</span>
                <span>{{planInfo.endDate}}</span>
              </div>
            </v-list-item>
            <v-list-item-title>
              <span class="text-h4">
                {{planInfo.planTitle}}
              </span>
            </v-list-item-title>
            <v-list-item>
              <span class="pr-4">
                  <v-icon>mdi-account-multiple</v-icon>
                  <span class="pl-1">{{ planInfo.userId }}</span>
                  <span class="pl-1" v-for="(partner, index) in planInfo.partner" :key="index" >, {{ partner.nickname }}</span>
                </span>
            </v-list-item>
          </v-list-item-content>
        </v-col>

      </v-list-item>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "PlanListItem",
  props: ["planInfo"]
  ,
}
</script>

<style>

</style>