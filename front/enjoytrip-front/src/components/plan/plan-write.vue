<template>
  <v-container class="py-0">
    <v-stepper v-model="e1" elevation="0">
      <v-stepper-header>
        <v-stepper-step :complete="e1 > 1" editable step="1">
          여행 정보 입력
        </v-stepper-step>

        <v-divider />

        <v-stepper-step :complete="e1 > 2" editable step="2">
          여행 일정 선택
        </v-stepper-step>

        <v-divider />

        <v-stepper-step :complete="e1 > 3" editable step="3">
          여행 계획 생성
        </v-stepper-step>
      </v-stepper-header>

      <v-stepper-items>
        <v-stepper-content step="1">
          <v-card elevation="0">
            <plan-write-info />
          </v-card>

          <v-col class="d-flex justify-center">
            <v-btn color="primary" @click="e1 = 2"
              rounded elevation="0" large>
              다음으로
            </v-btn>
          </v-col>
        </v-stepper-content>

        <v-stepper-content step="2">
          <v-card elevation="0">
            <plan-write-date />
          </v-card>

          <v-col class="d-flex justify-center">
            <v-btn color="primary" @click="e1 = 3"
              rounded elevation="0" large>
              다음으로
            </v-btn>
          </v-col>
        </v-stepper-content>

        <v-stepper-content step="3" class="pa-0">
          <plan-write-route />
        </v-stepper-content>
      </v-stepper-items>
    </v-stepper>
  </v-container>
</template>

<script>
import PlanWriteInfo from '@/components/plan/plan-write-info.vue';
import PlanWriteDate from '@/components/plan/plan-write-date.vue';
import planWriteRoute from "@/components/plan/plan-write-route.vue";
export default {
  components: { PlanWriteInfo, PlanWriteDate, planWriteRoute },
  data() {
    return {
      e1: 1,
    }
  }

};
</script>

<style></style>
